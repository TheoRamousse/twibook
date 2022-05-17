class User {
  readonly id: string;
  private _cars: Array<Car>
  private _firstName: string;
  private _lastName: string;
  private _nickName: string;
  private _imageUrl: string;
  private _birthDate: Date;
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
     this._cars = [];
     this._firstName = firstName;
     this._lastName = lastName;
     this._nickName = nickName;
     this._imageUrl = imageUrl;
     this._birthDate = birthDate;
     this.email = email;
     this.hashedPwd = hashedPwd;
 }

  public get firstName(){
    return this._firstName;
  }

  public set firstName(theFirstName: string){
    if(this._firstName == null || this._firstName == "" || this._firstName.length > 50){
      throw new Error("-firstName- est invalide");
    }
    this._firstName = theFirstName;
  }

  public get lastname(){
  return this._lastName;
  }

  public set lastName(theLastName: string){
    if(this._lastName == null || this._lastName == "" || this._lastName.length > 50){
      throw new Error("-LastName- est invalide");
    }
    this._lastName = theLastName;
  }

  public get nickName(){
    return this._nickName;
  }

  public set nickName(theNickName: string){
    if(this._nickName == null || this._nickName == "" || this._nickName.length > 50){
      throw new Error("-nickName- est invalide");
    }
    this._nickName = theNickName;
  }

  public get imageUrl(){
    return this._imageUrl;
  }

  public set imageUrl(theImageUrl: string){
    if(this._imageUrl == null || this._imageUrl == "" || this._imageUrl.length > 50){
      throw new Error("-imageUrl- est invalide");
    }
    this._imageUrl = theImageUrl;
  }

  public get birthDate(){
    return this._birthDate;
  }

  public set birthDate(theBirthDate: Date){
    this._birthDate = theBirthDate;
  }

  public addCars(carToAdd: Car){
    this._cars.push(carToAdd);
  }

  public removeCar(carToRemove: Car){
    this._cars.forEach((element, index)=> {
      if(element.isEqual(carToRemove)) this._cars.splice(index, 1);
    });
  }

}
