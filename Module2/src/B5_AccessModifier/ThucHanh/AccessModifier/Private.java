package B5_AccessModifier.ThucHanh.AccessModifier;

public class Private {
    static class A{

        private int data=40;

        private void msg(){System.out.println("Hello java");}

    }



    public static class Simple{

        public static void main(String args[]){

            A obj=new A();

            System.out.println(obj.data);//Compile Time Error

            obj.msg();//Compile Time Error

        }

    }
}
