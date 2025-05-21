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
interface SaveToDB{ /*here we make use of oops principles(abstraction,inheritance and polymorphism) to solve 
    OCP . now in future if we want to add any extra method of saving we use interface and implement it and dynamically call
    save , no need to modify existing function/class */  */
  void save(Guide g);
 
}
class SaveToSql implements SaveToDB{
    public void save(Guide g){
        System.out.println("Saved to Sql");
    }
}
class SaveToMongo implements SaveToDB{
    public void save(Guide g){
        System.out.println("Saved to Mongo");
    }
}
class SaveToCassandra implements SaveToDB{
    public void save(Guide g){
        System.out.println("Saved to Cassandra");
    }
}
class FollowedOCP{
    public static void main(String[] args) {
        Guide guide=new Guide();
        guide.addProject(new Project("AI",1));
        guide.addProject(new Project("Cloud Computing",2));
        Count cnt=new Count(guide);
        cnt.countStudents();
      SaveToDB sql=new SaveToSql();
      SaveToDB mongo=new SaveToMongo();
SaveToDB cass=new SaveToCassandra();
sql.save(guide);
mongo.save(guide);
cass.save(guide);

    }
}
