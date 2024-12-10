
;
public abstract class PERSON {
  String Name;
  String Email;
  String Phone;
  String Password;
  Role personrole;
    public PERSON(){}

    public PERSON(String Name, String Email, String Phone, String Password, Role personrole) {
        this.Name = Name;
        this.Email = Email;
        this.Phone = Phone;
        this.Password = Password;
        this.personrole = personrole;
    }

    public void setPersonrole(Role personrole) {
        this.personrole = personrole;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public String getPassword() {
        return Password;
    }
   public void Veiw_Info(){
   System.out.println("Name: "+Name+"Email: "+Email+"Phone: "+Phone+"Password: "+Password+"Role"+personrole);
   }
  
   public boolean Login(String username,String password){
   if(username.equals(this.Email)&&password.equals(this.Password)){
   System.out.println("login successful");
   return true;
   }
   else {
     System.out.println("Invalid username or password");
     return false;
   }
   }
}
