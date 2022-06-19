import { Car } from './Car'
import { validateNewUser } from './Validator'

export class User {
  private _id: string;
  private readonly _cars: Array<Car>
  private _firstName: string;
  private _lastName: string;
  private _nickName: string;
  private _imageUrl: string;
  private _birthDate: Date;
  private readonly _email: string;
  private readonly _hashedPwd: string;
  private readonly _idPosts: Array<string>


  public constructor(id: string,
    firstName: string,
    lastName: string,
    nickName: string,
    email: string,
    hashedPwd: string,
    imageUrl: string = "",
    birthDate: Date = null,
    cars: Car[] = [],
    idPosts: string[] = []) {

    validateNewUser(id, firstName, lastName, nickName, email, hashedPwd);

    this._id = id;
    this._cars = cars;
    this._idPosts = idPosts;
    this._firstName = firstName;
    this._lastName = lastName;
    this._nickName = nickName;
    this._imageUrl = imageUrl;
    this._birthDate = birthDate;
    this._email = email;
    this._hashedPwd = hashedPwd;
  }

  public get cars(): Car[] {
    return this._cars;
  }

  public get posts(): string[] {
    return this._idPosts;
  }

  public get firstName() {
    return this._firstName;
  }

  public set firstName(theFirstName: string) {
    if (theFirstName == null || theFirstName == "" || theFirstName.length > 50) {
      throw new Error("-firstName- est invalide");
    }
    this._firstName = theFirstName;
  }

  public get lastName() {
    return this._lastName;
  }

  public set lastName(theLastName: string) {
    if (theLastName == null || theLastName == "" || theLastName.length > 50) {
      throw new Error("-LastName- est invalide");
    }
    this._lastName = theLastName;
  }

  public get nickName() {
    return this._nickName;
  }

  public set nickName(theNickName: string) {
    if (theNickName == null || theNickName == "" || theNickName.length > 50) {
      throw new Error("-nickName- est invalide");
    }
    this._nickName = theNickName;
  }

  public get imageUrl() {
    return this._imageUrl;
  }

  public get id() {
    return this._id;
  }

  public set id(value: string) {
    this._id = value
  }

  public set imageUrl(theImageUrl: string) {
    if (theImageUrl == null || theImageUrl == "" || theImageUrl.length > 50) {
      throw new Error("-imageUrl- est invalide");
    }
    this._imageUrl = theImageUrl;
  }

  public get birthDate() {
    return this._birthDate;
  }

  public set birthDate(theBirthDate: Date) {
    this._birthDate = theBirthDate;
  }

  public addCar(carToAdd: Car) {
    this._cars.push(carToAdd);
  }

  public removeCar(carToRemove: Car) {
    this._cars.forEach((element, index) => {
      if (element.isEqual(carToRemove)) this._cars.splice(index, 1);
    });
  }

  public addPost(postId: string) {
    this._idPosts.push(postId);
  }

  public removePost(postId: String) {
    this._idPosts.forEach((element, index) => {
      if (element == postId) this._idPosts.splice(index, 1);
    });
  }


  public get email() {
    return this._email;
  }


  public get hashedPassword() {
    return this._hashedPwd;
  }


}
