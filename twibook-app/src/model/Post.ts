class Post {
   readonly id: string;
   private text: string;
   private publication_date: Date;
   private first_comment_text: string
   private first_comment_user_image_url: string
   private first_comment_user_nick_name: string

   public constructor(id: string,
    text: string,
    publication_date: Date,
    first_comment_text: string,
    first_comment_user_image_url: string,
    first_comment_user_nick_name: string) {

      validateNewPost(id, text, first_comment_text, first_comment_user_image_url, first_comment_user_nick_name);

      this.id = id;
      this.text = text;
      this.publication_date = publication_date;
      this.first_comment_text = first_comment_text;
      this.first_comment_user_image_url = first_comment_user_image_url;
      this.first_comment_user_nick_name = first_comment_user_nick_name;
  }
}
