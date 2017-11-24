import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.io.IOException;
import java.util.Scanner;

public class Tips {
    //打印出学院的提示信息.
    public void allCollage() throws IOException{
        Tools tools = new Tools();
        Map<String,ArrayList> collageToMajor = tools.getCollageToMajorMap();
        Iterator<String> iterator1 = collageToMajor.keySet().iterator();
        System.out.println("所有的学院名:");
        int count = 1;
        while(iterator1.hasNext()){
            String key = iterator1.next();
            System.out.printf("%-15s",key);
            if(count%3 == 0){
                System.out.println();
            }
            count++;
        }
    }

    //提示输入学院，学号,并进行搜索.
    public void numTip() throws IOException{
        System.out.println();
        System.out.println();
        Searcher searcher = new Searcher();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学院名(例:通信与信息工程学院):");
        String collageName = scanner.nextLine();
        System.out.println("请输入学号(例:2017210XXX):");
        String num = scanner.nextLine();
        System.out.println();

        searcher.searchStudentByNum(num,collageName);
    }

    //提示输入学院，姓名,并进行搜索.
    public void nameTip() throws IOException{
        System.out.println();
        System.out.println();
        Searcher searcher = new Searcher();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学院名(例:通信与信息工程学院):");
        String collageName = scanner.nextLine();
        System.out.println("请输入姓名(例:陈XX):");
        String name = scanner.nextLine();
        System.out.println();

        searcher.searchStudentByName(name,collageName);
    }

    //打印容器的内容.
    public void showTheContainer(Map<String,Map<String,Map<String,Map<String,ArrayList<String>>>>> tempContainer){
        Iterator<String> iterator_01 = tempContainer.keySet().iterator();
        while(iterator_01.hasNext()){
            String key_01 = iterator_01.next();
            Map<String,Map<String,Map<String,ArrayList<String>>>> majorTemp = tempContainer.get(key_01);
            Iterator iterator_02 = majorTemp.keySet().iterator();
            System.out.println(key_01 + " - 学院 - 第一层");
            System.out.println();
            while(iterator_02.hasNext()){
                String key_02 = iterator_02.next().toString();
                Map<String,Map<String,ArrayList<String>>> classTemp = majorTemp.get(key_02);
                Iterator iterator_03 = classTemp.keySet().iterator();
                System.out.println(" " + key_02 + " - 专业 - 第二层");
                System.out.println();
                while(iterator_03.hasNext()) {
                    String key_03 = iterator_03.next().toString();
                    Map<String, ArrayList<String>> studentTemp = classTemp.get(key_03);
                    Iterator iterator_04 = studentTemp.keySet().iterator();
                    System.out.println("  " + key_03 + " - 班级编号 - 第三层");
                    System.out.println();
                    while(iterator_04.hasNext()){
                        String key_04 = iterator_04.next().toString();
                        ArrayList<String> infoTemp = studentTemp.get(key_04);
                        System.out.printf("   %s - 姓名 - 第四层",key_04);
                        System.out.printf("    个人信息:");
                        for(int i=0; i<infoTemp.size(); i++){
                            System.out.printf("%s  ",infoTemp.get(i));
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
        }
    }
}
