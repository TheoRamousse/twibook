import { validateNewPost } from './Validator'


export class Post {
  private readonly _id: string;
  private _text: string;
  private _userImageUrl: string;
  private _userNickName: string;
  private readonly _publicationDate: Date;
  private _firstCommentText?: string
  private _firstCommentUserImageUrl?: string
  private _firstCommentUserNickName?: string
  private _firstCommentPublicationDate?: Date
  private _idComments: Array<string>
  private _imageUrl?: string

  public constructor(id: string,
    text: string,
    publicationDate: Date,
    userImageUrl: string,
    userNickName: string,
    firstCommentPublicationDate?: Date,
    firstCommentText?: string,
    firstCommentUserImageUrl?: string,
    firstCommentUserNickName?: string,
    imageUrl?: string,
    idComments: Array<string> = []) {

    validateNewPost(id, text);

    this._id = id;
    this._text = text;
    this._publicationDate = publicationDate;
    this._firstCommentText = firstCommentText;
    this._firstCommentUserImageUrl = firstCommentUserImageUrl;
    this._firstCommentUserNickName = firstCommentUserNickName;
    this._firstCommentPublicationDate = firstCommentPublicationDate
    this._userNickName = userNickName
    this._userImageUrl = userImageUrl
    this._idComments = idComments
    this._imageUrl = imageUrl
  }

  public get id() {
    return this._id;
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

  public get imageUrl() {
    return this._imageUrl;
  }

  public set imageUrl(theImageUrl: string) {
    this._imageUrl = theImageUrl;
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


  public get firstCommentText() {
    return this._firstCommentText;
  }


  public get firstCommentPublicationDate() {
    return this._firstCommentPublicationDate;
  }


  public get firstCommentUserNickName() {
    return this._firstCommentUserNickName;
  }



  public get firstCommentUserImageUrl() {
    return this._firstCommentUserImageUrl;
  }


  public addComment(commentIdToAdd: string) {
    this._idComments.push(commentIdToAdd);
  }

  public get idComments() {
    return this._idComments
  }

  public removeComment(commentIdToRemove: string) {
    this._idComments.forEach((element, index) => {
      if (element == commentIdToRemove) this._idComments.splice(index, 1);
    });
  }


  public set firstCommentText(text: string) {
    this._firstCommentText = text
  }


  public set firstCommentPublicationDate(date: Date) {
    this._firstCommentPublicationDate = date
  }


  public set firstCommentUserNickName(nickName: string) {
    this._firstCommentUserNickName = nickName
  }



  public set firstCommentUserImageUrl(imageUrl: string) {
    this._firstCommentUserImageUrl = imageUrl
  }


}
