package patterns.builder;

/**
 * @Author <a href="mailto:einsamstorch@qq.com">Liqun_Wang</a>
 * @Date: 2020/8/31 16:33
 */
public interface ComputerConfigBuilder {
    void setCPU();

    void setMemory();

    void setHardDisk();

    void setKeyboard();

    void setMouse();

    Computer getComputer();
}