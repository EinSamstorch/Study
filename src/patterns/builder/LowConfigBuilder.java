package patterns.builder;

/**
 * @Author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @Date: 2020/8/31 16:33
 */
public class LowConfigBuilder implements ComputerConfigBuilder {

    private Computer mComputer;

    public LowConfigBuilder() {
        this.mComputer = new Computer();
    }

    @Override
    public void setCPU() {
        mComputer.setCPU("i5");
    }

    @Override
    public void setMemory() {
        mComputer.setMemory("8G");
    }

    @Override
    public void setHardDisk() {
        mComputer.setHardDisk("500G");
    }

    @Override
    public void setKeyboard() {
        mComputer.setKeyboard("薄膜键盘");
    }

    @Override
    public void setMouse() {
        mComputer.setMouse("有线鼠标");
    }

    @Override
    public Computer getComputer() {
        return mComputer;
    }
}
