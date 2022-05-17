function validateNewComment(id: string,
  text: string,
  userNickName: string,
  userImageUrl: string) {
    if(id == null || id == "" || id.length > 50){
      throw new Error("-id- est invalide");
    }
    if(text == null || text == "" || text.length > 512){
      throw new Error("-text- est invalide");
    }
    if(userNickName == null || userNickName == "" || userNickName.length > 30){
      throw new Error("-userNickName- est invalide");
    }
    if(userImageUrl == null || userImageUrl == "" || userImageUrl.length > 256){
      throw new Error("-userImageUrl- est invalide");
    }
  }

function validateNewPost(id: string,
  text: string,
  firstCommentText: string,
  firstCommentUserImageUrl: string,
  firstCommentUserNickName: string) {
    if(id == null || id == "" || id.length > 50){
      throw new Error("-id- est invalide");
    }
    if(text == null || text == "" || text.length > 512){
      throw new Error("-text- est invalide");
    }
    if(firstCommentText == null || firstCommentText == "" || firstCommentText.length > 512){
      throw new Error("-firstCommentText- est invalide");
    }
    if(firstCommentUserImageUrl == null || firstCommentUserImageUrl == "" || firstCommentUserImageUrl.length > 256){
      throw new Error("-first_comment_user_image_url- est invalide");
    }
    if(firstCommentUserNickName == null || firstCommentUserNickName == "" || firstCommentUserNickName.length > 30){
      throw new Error("-first_comment_user_nick_name- est invalide");
    }
  }

function validateNewUser(id: string,
  firstName: string,
  lastName: string,
  nickName: string,
  imageUrl: string,
  email: string,
  hashedPwd: string) {
    if(id == null || id == "" || id.length > 50){
      throw new Error("-id- est invalide");
    }
    if(firstName == null || firstName == "" || firstName.length > 50){
      throw new Error("-firstName- est invalide");
    }
    if(lastName == null || lastName == "" || lastName.length > 30){
      throw new Error("-lastName- est invalide");
    }
    if(nickName == null || nickName == "" || nickName.length > 30){
      throw new Error("-nickName- est invalide");
    }
    if(imageUrl == null || imageUrl == "" || imageUrl.length > 256){
      throw new Error("-imageUrl- est invalide");
    }
    if(email == null || email == "" || email.length > 50){
      throw new Error("-email- est invalide");
    }
    if(hashedPwd == null || hashedPwd == "" || hashedPwd.length > 50){
      throw new Error("-hashedPwd- est invalide");
    }
  }

  function validateNewCar(id: string,
    model: string,
    brand: string) {
      if(id == null || id == ""){
        throw new Error("-id- est invalide");
      }
      if(model == null || model == ""){
        throw new Error("-model- est invalide");
      }
      if(brand == null || brand == ""){
        throw new Error("-brand- est invalide");
      }
    }
