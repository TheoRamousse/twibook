import { validateNewPost } from './Validator'

export class Post {
  private readonly _id: string;
  private _text: string;
  private _userImageUrl: string;
  private _userNickName: string;
  private readonly _publicationDate: Date;
  private readonly _firstCommentText: string
  private readonly _firstCommentUserImageUrl: string
  private readonly _firstCommentUserNickName: string
  private readonly _firstCommentPublicationDate: Date
  private readonly _idComments: Array<string>
  private _imageUrl: string

  public constructor(id: string,
    text: string,
    imageUrl: string,
    publicationDate: Date,
    userImageUrl: string,
    userNickName: string,
    firstCommentPublicationDate: Date,
    firstCommentText: string,
    firstCommentUserImageUrl: string,
    firstCommentUserNickName: string,
    idComments: Array<string>) {

    validateNewPost(id, text, firstCommentText, firstCommentUserImageUrl, firstCommentUserNickName);

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

  public removeComment(commentIdToRemove: string) {
    this._idComments.forEach((element, index) => {
      if (element == commentIdToRemove) this._idComments.splice(index, 1);
    });
  }



}
