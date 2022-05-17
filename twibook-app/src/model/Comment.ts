class Comments {
  readonly id: string;
  private text: string;
  readonly publicationDate: Date;
  private userNickName: string;
  private userImageUrl: string

  public constructor(id: string,
    text: string,
    publicationDate: Date,
    userNickName: string,
    userImageUrl: string) {

      validateNewComment(id, text, userNickName, userImageUrl);

      this.id = id;
      this.text = text;
      this.publicationDate = publicationDate;
      this.userNickName = userNickName;
      this.userImageUrl = userImageUrl;
  }


}
