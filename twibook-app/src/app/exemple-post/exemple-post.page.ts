import { Component } from '@angular/core';
import { Post } from '../../model/Post'

@Component({
  selector: 'app-exemple-post',
  templateUrl: 'exemple-post.page.html',
  styleUrls: ['exemple-post.page.scss']
})
export class ExemplePostPage {
  post: Post
  constructor() {
    this.post = new Post("monId", "Ceci est un post de test, le texte fournit n'a donc aucun intérêt ;)", new Date(Date.now()), "https://ultimatecourses.com/assets/category/angular-2052c478f3fcf0adc1c1c5aad5a4d9fe46a896ccda52ee6b8383b687b0c61042.svg", "Toto", new Date(Date.now()), "C'est vrai que ce post n'a aucun intérêt !!!", "uneAutreImage", "Titi", new Array())
  }

}
