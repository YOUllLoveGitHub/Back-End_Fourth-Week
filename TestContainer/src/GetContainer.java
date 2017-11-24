import java.util.*;
import java.io.IOException;

public class GetContainer {
    //得到储存一学院学生的容器.(参数:学院名)
    public Map<String,Map<String,Map<String,Map<String,ArrayList<String>>>>> getCollageContainer(String theCollageName) throws IOException {
        Tools tools = new Tools();
        Map<String,Map<String,Map<String,Map<String,ArrayList<String>>>>> aCollage0ToMajor = new HashMap<>();
        Map<String,ArrayList> collageToMajorList = tools.getCollageToMajorMap();
        Map<String,Map<String,Map<String,ArrayList<String>>>> temp = new HashMap<>();
        Iterator<String> iterator = collageToMajorList.get(theCollageName).iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            temp.put(key,getMajorContainer(key).get(key));
        }
        aCollage0ToMajor.put(theCollageName,temp);
        return aCollage0ToMajor;
    }

    //得到储存一专业学生的容器.(参数:专业名)
    public Map<String,Map<String,Map<String,ArrayList<String>>>> getMajorContainer(String majorName) throws IOException{
        Tools tools = new Tools();
        Map<String,Map<String,Map<String,ArrayList<String>>>> aMajorToClass = new HashMap<>();
        Map<String,Map<String,ArrayList<String>>> aClassToStudent = new HashMap<>();
        Map<String,List<String>> majorToClassList = tools.getMajorToClassList();
        List<String> ClassList = majorToClassList.get(majorName);
        Iterator<String> iterator = ClassList.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            aClassToStudent.put(key,tools.getClassList(key));
        }
        aMajorToClass.put(majorName,aClassToStudent);
        return aMajorToClass;
    }
}
