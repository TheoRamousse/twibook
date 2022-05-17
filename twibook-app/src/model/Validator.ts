function validateNewComment(id: string,
  text: string,
  user_nick_name: string,
  user_image_url: string) {
    if(id == null || id == "" || id.length > 50){
      throw new Error("-id- est invalide");
    }
    if(text == null || text == "" || text.length > 512){
      throw new Error("-text- est invalide");
    }
    if(user_nick_name == null || user_nick_name == "" || user_nick_name.length > 30){
      throw new Error("-user_nick_name- est invalide");
    }
    if(user_image_url == null || user_image_url == "" || user_image_url.length > 256){
      throw new Error("-user_image_url- est invalide");
    }
  }

function validateNewPost(id: string,
  text: string,
  first_comment_text: string,
  first_comment_user_image_url: string,
  first_comment_user_nick_name: string) {
    if(id == null || id == "" || id.length > 50){
      throw new Error("-id- est invalide");
    }
    if(text == null || text == "" || text.length > 512){
      throw new Error("-text- est invalide");
    }
    if(first_comment_text == null || first_comment_text == "" || first_comment_text.length > 512){
      throw new Error("-first_comment_text- est invalide");
    }
    if(first_comment_user_image_url == null || first_comment_user_image_url == "" || first_comment_user_image_url.length > 256){
      throw new Error("-first_comment_user_image_url- est invalide");
    }
    if(first_comment_user_nick_name == null || first_comment_user_nick_name == "" || first_comment_user_nick_name.length > 30){
      throw new Error("-first_comment_user_nick_name- est invalide");
    }
  }

function validateNewUser(id: string,
  first_name: string,
  last_name: string,
  nick_name: string,
  image_url: string,
  email: string,
  hashed_pwd: string) {
    if(id == null || id == "" || id.length > 50){
      throw new Error("-id- est invalide");
    }
    if(first_name == null || first_name == "" || first_name.length > 50){
      throw new Error("-first_name- est invalide");
    }
    if(last_name == null || last_name == "" || last_name.length > 30){
      throw new Error("-last_name- est invalide");
    }
    if(nick_name == null || nick_name == "" || nick_name.length > 30){
      throw new Error("-nick_name- est invalide");
    }
    if(image_url == null || image_url == "" || image_url.length > 256){
      throw new Error("-image_url- est invalide");
    }
    if(email == null || email == "" || email.length > 50){
      throw new Error("-email- est invalide");
    }
    if(hashed_pwd == null || hashed_pwd == "" || hashed_pwd.length > 50){
      throw new Error("-hashed_pwd- est invalide");
    }
  }
