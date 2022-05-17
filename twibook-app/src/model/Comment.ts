class Comments {
  readonly id: string;
  private text: string;
  private publication_date: Date;
  private user_nick_name: string;
  private user_image_url: string

  public constructor(id: string,
    text: string,
    publication_date: Date,
    user_nick_name: string,
    user_image_url: string) {

      validateNewComment(id, text, user_nick_name, user_image_url);

      this.id = id;
      this.text = text;
      this.publication_date = publication_date;
      this.user_nick_name = user_nick_name;
      this.user_image_url = user_image_url;
  }
}
