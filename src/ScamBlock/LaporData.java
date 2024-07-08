package ScamBlock;

public class LaporData {
    private String time;
    private String kejadian;
    private String kronologi;
    private String name;
    private String address;
    private String gender;
    private String number;

    public LaporData(String time, String kejadian, String kronologi, String name, String address, String gender, String number) {
        this.time = time;
        this.kejadian = kejadian;
        this.kronologi = kronologi;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.number = number;
    }

    public String getTime() {
        return time;
    }
    public String getKejadian() {
        return kejadian;
    }

    public String getKronologi() {
        return kronologi;
    }
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getNumber() {
        return number;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setKejadian(String kejadian) {
        this.kejadian = kejadian;
    }
    public void setKronologi(String kronologi) {
        this.kronologi = kronologi;
    }

    public void setName(String name) {
        this.name =  name;
    }

    public void setAddress(String address) {
        this.address =  address;
    }
    
    public void setGender(String gender) {
        this.gender =  gender;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public void LaporData(String time2, String kejadian2, String name2, String address2, String gender2,
            String number2) {
                
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'LaporData'");
    }
}
