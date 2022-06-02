import { validateNewComment } from './Validator'

export class Comment {
  private _id: string;
  private _text: string;
  private readonly _publicationDate: Date;
  private _userNickName: string;
  private _userImageUrl: string

  public constructor(id: string,
    text: string,
    publicationDate: Date,
    userNickName: string,
    userImageUrl: string) {

    validateNewComment(id, text, userNickName, userImageUrl);

    this._id = id;
    this._text = text;
    this._publicationDate = publicationDate;
    this._userNickName = userNickName;
    this._userImageUrl = userImageUrl;
  }

  public get id() {
    return this._id;
  }

  public set id(newValue: string) {
    this._id = newValue
  }

  public get text() {
    return this._text;
  }

  public set text(theText: string) {
    if (theText == null || theText == "" || theText.length > 50) {
      throw new Error("-text- est invalide");
    }
    this._text = theText;
  }


  public get publicationDate() {
    return this._publicationDate;
  }


  public get userNickName() {
    return this._userNickName;
  }

  public set userNickName(theUserNickName: string) {
    if (theUserNickName == null || theUserNickName == "" || theUserNickName.length > 50) {
      throw new Error("-userNickName- est invalide");
    }
    this._userNickName = theUserNickName;
  }


  public get userImageUrl() {
    return this._userImageUrl;
  }

  public set userImageUrl(theUserImageUrl: string) {
    if (theUserImageUrl == null || theUserImageUrl == "" || theUserImageUrl.length > 50) {
      throw new Error("-userImageUrl- est invalide");
    }
    this._userImageUrl = theUserImageUrl;
  }
}
