public class AdminDAO {

    public static List<Admin> getAdmins() {
        
        List<Admin> adminList = new ArrayList<Admin>();
        
        adminList.add(new Admin("jorge22@gmail.com", "jorge22", "sdfjlsafl", "Superior"));
        adminList.add(new Admin("sandra48@gmail.com", "sandra48", "cvbxbxnxvcn", "Moderator"));
        adminList.add(new Admin("sebastian_12@gmail.com", "sebastian_12", "trywrertye", "Moderator"));

    }
}
