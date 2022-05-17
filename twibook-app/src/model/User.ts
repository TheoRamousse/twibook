class User {
  readonly id: string;
  private first_name: string;
  private last_name: string;
  private nick_name: string;
  private image_url: string;
  private birth_date: Date;
  readonly email: string;
  readonly hashed_pwd: string;

  public constructor(id: string,
   first_name: string,
   last_name: string,
   nick_name: string,
   image_url: string,
   birth_date: Date,
   email: string,
   hashed_pwd: string) {

     validateNewUser(id, first_name, last_name, nick_name, image_url, email, hashed_pwd);

     this.id = id;
     this.first_name = first_name;
     this.last_name = last_name;
     this.nick_name = nick_name;
     this.image_url = image_url;
     this.birth_date = birth_date;
     this.email = email;
     this.hashed_pwd = hashed_pwd;
 }
}
