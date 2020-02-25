package test;

enum Single01 {

    /**
     * fe
     */
    Instance;
    public void doSome(){
        System.out.println("单例");
    }
}

class A{
    public static void main(String[] args) {
        Single01.Instance.doSome();
    }
}
