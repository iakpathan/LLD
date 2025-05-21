import java.util.*;
class Project{
    String name;
    int noofstudent;
    Project(String name,int noofstudent){
        this.name=name;
        this.noofstudent=noofstudent;
    }
}
class Guide{
    List<Project>projects=new ArrayList<>();
    public void addProject(Project p){
        projects.add(p);
    }
    public List<Project> getProject(){
        return projects;
    }
    
}
class Count{
    Guide g;
    Count(Guide g){
        this.g=g;
    }
    int total=0;
    public void countStudents(){
  for(Project p:g.getProject()){
    total+=p.noofstudent;
    }
    System.out.println("No.of Projects handled by this guide:"+total);
    }
   
}
class SaveToDB{ /*if we in future want to add file storage or postgree or cassandra we have to 
    modify existing saveToDb class,OCP violates i.e. Open to add and close to modify  */
  Guide g;
  SaveToDB(Guide g){
        this.g=g;
    }
 public void saveTosql(){
    System.out.println("Saved to sql");
 }
 public void saveTomongo(){
    System.out.println("Saved to Mongo");
 }
}
class ViolatedOCP{
    public static void main(String[] args) {
        Guide guide=new Guide();
        guide.addProject(new Project("AI",1));
        guide.addProject(new Project("Cloud Computing",2));
        Count cnt=new Count(guide);
        cnt.countStudents();
        SaveToDB save=new SaveToDB(guide);
        save.saveTomongo();
        save.saveTosql();
    }
}
