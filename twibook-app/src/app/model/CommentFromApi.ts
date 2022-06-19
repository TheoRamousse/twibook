import { Comment } from "./Comment";

export class CommentFromApi {
    public id: string;
    public text: string;
    public publicationDate: Date;
    public userNickName: string;
    public userImageUrl: string;

    public constructor(comment: Comment) {
        this.id = comment.id;
        this.text = comment.text;
        this.publicationDate = comment.publicationDate;
        this.userNickName = comment.userNickName;
        this.userImageUrl = comment.userImageUrl;
    }
}