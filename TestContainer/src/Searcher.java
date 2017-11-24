import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.io.IOException;

public class Searcher {

    //按学号搜索学生的信息.参数(学号,学院名)
    public void searchStudentByNum(String num,String collageName) throws IOException{
        GetContainer getContainer = new GetContainer();
        Map<String,Map<String,Map<String,Map<String,ArrayList<String>>>>> tempContainer = getContainer.getCollageContainer(collageName);
        Iterator<String> iterator_01 = tempContainer.keySet().iterator();
        while(iterator_01.hasNext()){
            String key_01 = iterator_01.next();
            Map<String,Map<String,Map<String,ArrayList<String>>>> majorTemp = tempContainer.get(key_01);
            Iterator iterator_02 = majorTemp.keySet().iterator();
            while(iterator_02.hasNext()){
                String key_02 = iterator_02.next().toString();
                Map<String,Map<String,ArrayList<String>>> classTemp = majorTemp.get(key_02);
                Iterator iterator_03 = classTemp.keySet().iterator();
                while(iterator_03.hasNext()) {
                    String key_03 = iterator_03.next().toString();
                    Map<String, ArrayList<String>> studentTemp = classTemp.get(key_03);
                    Iterator iterator_04 = studentTemp.keySet().iterator();
                    while(iterator_04.hasNext()){
                        String key_04 = iterator_04.next().toString();
                        ArrayList<String> infoTemp = studentTemp.get(key_04);
                        if(num.equals(infoTemp.get(1))){
                            System.out.printf("%s  ",key_04);
                            for(int i=0; i<infoTemp.size(); i++){
                                System.out.printf("%s  ",infoTemp.get(i));
                            }
                        }
                    }
                }
            }
        }
    }

    //按姓名搜索学生的信息.参数(姓名,学院名)
    public void searchStudentByName(String name,String collageName) throws IOException{
        GetContainer getContainer = new GetContainer();
        Map<String,Map<String,Map<String,Map<String,ArrayList<String>>>>> tempContainer = getContainer.getCollageContainer(collageName);
        Iterator<String> iterator_01 = tempContainer.keySet().iterator();
        while(iterator_01.hasNext()){
            String key_01 = iterator_01.next();
            Map<String,Map<String,Map<String,ArrayList<String>>>> majorTemp = tempContainer.get(key_01);
            Iterator iterator_02 = majorTemp.keySet().iterator();
            while(iterator_02.hasNext()){
                String key_02 = iterator_02.next().toString();
                Map<String,Map<String,ArrayList<String>>> classTemp = majorTemp.get(key_02);
                Iterator iterator_03 = classTemp.keySet().iterator();
                while(iterator_03.hasNext()) {
                    String key_03 = iterator_03.next().toString();
                    Map<String, ArrayList<String>> studentTemp = classTemp.get(key_03);
                    Iterator iterator_04 = studentTemp.keySet().iterator();
                    while(iterator_04.hasNext()){
                        String key_04 = iterator_04.next().toString();
                        ArrayList<String> infoTemp = studentTemp.get(key_04);
                        if(name.equals(key_04)){
                            System.out.printf("%s  ",key_04);
                            for(int i=0; i<infoTemp.size(); i++){
                                System.out.printf("%s  ",infoTemp.get(i));
                            }
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}
