class Post {
   readonly id: string;
   private text: string;
   readonly publicationDate: Date;
   private firstCommentText: string
   private firstCommentUserImageUrl: string
   private firstCommentUserNickName: string

   public constructor(id: string,
    text: string,
    publicationDate: Date,
    firstCommentText: string,
    firstCommentUserImageUrl: string,
    firstCommentUserNickName: string) {

      validateNewPost(id, text, firstCommentText, firstCommentUserImageUrl, firstCommentUserNickName);

      this.id = id;
      this.text = text;
      this.publicationDate = publicationDate;
      this.firstCommentText = firstCommentText;
      this.firstCommentUserImageUrl = firstCommentUserImageUrl;
      this.firstCommentUserNickName = firstCommentUserNickName;
  }
}
