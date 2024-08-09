package main.java;

class Member {
    private int memberID;
    private int age;
    private Gender gender;
    private String name;
    private String email;
    private String licenseNub;
    private String address;
    private String phone;
    private boolean login;

	enum Gender {
	    MALE, FEMALE, OTHERSEXUAL
	}

    public Member(int memberID, int age, Gender gender, String name, String email, String licenseNub, String address, String phone, boolean login) {
        this.memberID = memberID;
        this.age = age;
        this.gender = gender;
        this.name = name;
        this.email = email;
        this.licenseNub = licenseNub;
        this.address = address;
        this.phone = phone;
        this.login = login;
    }

    // Getters and Setters
    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicenseNub() {
        return licenseNub;
    }

    public void setLicenseNub(String licenseNub) {
        this.licenseNub = licenseNub;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
