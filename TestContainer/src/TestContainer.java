import java.io.IOException;
import java.util.*;
import java.util.Map;

public class TestContainer {
    public static void main(String[] args) throws IOException {
        //创建了一个学院的容器.
        GetContainer getContainer = new GetContainer();
        Map<String,Map<String,Map<String,Map<String,ArrayList<String>>>>> TXContainer = getContainer.getCollageContainer("通信与信息工程学院");
        Tips tip = new Tips();
        //打印出这个容器.
        tip.showTheContainer(TXContainer);

        //打印出学院的提示信息.
        tip.allCollage();
        //提示输入学院，姓名,并进行搜索.
        tip.nameTip();
        //提示输入学院，学号,并进行搜索.
        tip.numTip();
    }
}
