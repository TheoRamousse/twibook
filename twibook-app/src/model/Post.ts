class Post {
   private readonly _id: string;
  private _text: string;
  private _userImageUrl: string;
  private _userNickName: string;
   private readonly _publicationDate: Date;
   private _firstCommentText: string
   private _firstCommentUserImageUrl: string
  private _firstCommentUserNickName: string
  private _firstCommentPublicationDate: Date

   public constructor(id: string,
    text: string,
    publicationDate: Date,
    firstCommentText: string,
    firstCommentUserImageUrl: string,
    firstCommentUserNickName: string) {

      validateNewPost(id, text, firstCommentText, firstCommentUserImageUrl, firstCommentUserNickName);

      this._id = id;
      this._text = text;
      this._publicationDate = publicationDate;
      this._firstCommentText = firstCommentText;
      this._firstCommentUserImageUrl = firstCommentUserImageUrl;
      this._firstCommentUserNickName = firstCommentUserNickName;
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






  public get firstCommentText() {
    return this._firstCommentText;
  }

  public set firstCommentText(theFirstCommentText: string) {
    if (theFirstCommentText == null || theFirstCommentText == "" || theFirstCommentText.length > 50) {
      throw new Error("-firstCommentText- est invalide");
    }
    this._firstCommentText = theFirstCommentText;
  }


  public get firstCommentPublicationDate() {
    return this._firstCommentPublicationDate;
  }


  public get firstCommentUserNickName() {
    return this._firstCommentUserNickName;
  }

  public set firstCommentUserNickName(theFirstCommentUserNickName: string) {
    if (theFirstCommentUserNickName == null || theFirstCommentUserNickName == "" || theFirstCommentUserNickName.length > 50) {
      throw new Error("-firstCommentUserNickName- est invalide");
    }
    this._firstCommentUserNickName = theFirstCommentUserNickName;
  }


  public get firstCommentUserImageUrl() {
    return this._firstCommentUserImageUrl;
  }

  public set firstCommentUserImageUrl(theFirstCommentUserImageUrl: string) {
    if (theFirstCommentUserImageUrl == null || theFirstCommentUserImageUrl == "" || theFirstCommentUserImageUrl.length > 50) {
      throw new Error("-firstCommentUserImageUrl- est invalide");
    }
    this._firstCommentUserImageUrl = theFirstCommentUserImageUrl;
  }









}
