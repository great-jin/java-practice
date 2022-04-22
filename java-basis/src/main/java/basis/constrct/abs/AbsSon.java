package basis.constrct.abs;

/**
 * 一个类可以实现多个接口类，但只能继承一个父类
 * 子类必须继承父类所以抽象方法，否则必须声明为抽象类
 */
class AbsSon extends AbsFather {

    @Override
    public int AddElem(int a, int b) {
        return a + b;
    }

}