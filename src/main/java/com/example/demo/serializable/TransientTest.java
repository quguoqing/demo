package com.example.demo.serializable;

import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author: chunmu
 * @Date: 2019/8/28 15:34
 * @Description:
 */
public class TransientTest {

    public static void main(String[] args)
    {
        // LabeledPoint label = new LabeledPoint("Book", 5.00, 5.00);
        try
        {
            // 写入前
            // System.out.println(label);
            // ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/quguoqing/Label.txt"));
            // out.writeObject(label);
            // out.close();

            // 写入后
            // System.out.println(label);
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/quguoqing/Label.txt"));
            LabeledPoint1 label1 = (LabeledPoint1) in.readObject();
            in.close();

            // 读出
            System.out.println(label1);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    static class LabeledPoint1 implements Serializable
    {
        private static final long serialVersionUID = 5539137422889233201L;

        public LabeledPoint1(String str, double x, double y)
        {
            label = str;
            point = new Point2D.Double(x, y);
        }
        private void writeObject(ObjectOutputStream out) throws IOException
        {

            out.defaultWriteObject();
            out.writeDouble(point.getX());
            out.writeDouble(point.getY());
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
        {

            in.defaultReadObject();
            double x = in.readDouble() + 1.0;
            double y = in.readDouble() + 1.0;
            point = new Point2D.Double(x, y);
        }

        @Override
        public String toString()
        {
            return getClass().getName()+ "[label = " + label+ ", point.getX() = " + point.getX()+ ", point.getY() = " + point.getY()+ "]";
        }

        private String label;

        transient private Point2D.Double point;
    }

}
