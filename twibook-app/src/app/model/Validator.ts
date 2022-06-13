export function validateNewComment(id: string,
  text: string,
  userNickName: string,
  userImageUrl: string) {
  if (id == null || id == "" || id.length > 50) {
    throw new Error("-id- est invalide");
  }
  if (text == null || text == "" || text.length > 512) {
    throw new Error("-text- est invalide");
  }
  if (userNickName == null || userNickName == "" || userNickName.length > 30) {
    throw new Error("-userNickName- est invalide");
  }
  if (userImageUrl == null || userImageUrl == "" || userImageUrl.length > 256) {
    throw new Error("-userImageUrl- est invalide");
  }
}

export function validateNewPost(id: string,
  text: string) {
  if (id == null || id == "" || id.length > 50) {
    throw new Error("-id- est invalide");
  }
  if (text == null || text == "" || text.length > 512) {
    throw new Error("-text- est invalide");
  }
}

export function validateNewUser(id: string,
  firstName: string,
  lastName: string,
  nickName: string,
  email: string,
  hashedPwd: string) {
  if (id == null || id == "" || id.length > 50) {
    throw new Error("-id- est invalide");
  }
  if (firstName == null || firstName == "" || firstName.length > 50) {
    throw new Error("-firstName- est invalide");
  }
  if (lastName == null || lastName == "" || lastName.length > 30) {
    throw new Error("-lastName- est invalide");
  }
  if (nickName == null || nickName == "" || nickName.length > 30) {
    throw new Error("-nickName- est invalide");
  }
  if (email == null || email == "" || email.length > 50) {
    throw new Error("-email- est invalide");
  }
  if (hashedPwd == null || hashedPwd == "" || hashedPwd.length > 200) {
    throw new Error("-hashedPwd- est invalide");
  }
}

export function validateNewCar(id: string,
  model: string,
  brand: string) {
  if (id == null || id == "") {
    throw new Error("-id- est invalide");
  }
  if (model == null || model == "") {
    throw new Error("-model- est invalide");
  }
  if (brand == null || brand == "") {
    throw new Error("-brand- est invalide");
  }
}
