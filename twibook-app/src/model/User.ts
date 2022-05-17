class User {
  readonly id: string;
  public cars: Array<string>
  public firstName: string;
  public lastName: string;
  public nickName: string;
  public imageUrl: string;
  public birthDate: Date;
  readonly email: string;
  readonly hashedPwd: string;

  public constructor(id: string,
    firstName: string,
    lastName: string,
    nickName: string,
    imageUrl: string,
    birthDate: Date,
   email: string,
   hashedPwd: string) {

     validateNewUser(id, firstName, lastName, nickName, imageUrl, email, hashedPwd);

     this.id = id;
     this.cars = [];
     this.firstName = firstName;
     this.lastName = lastName;
     this.nickName = nickName;
     this.imageUrl = imageUrl;
     this.birthDate = birthDate;
     this.email = email;
     this.hashedPwd = hashedPwd;
 }
}
