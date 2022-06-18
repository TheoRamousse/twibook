import { Post } from './Post';
import { validateNewPost } from './Validator'


export class PostFromApi {
    public id: string;
    public text: string;
    public userImageUrl: string;
    public userNickName: string;
    public publicationDate: Date;
    public firstCommentText?: string
    public firstCommentUserImageUrl?: string
    public firstCommentUserNickName?: string
    public firstCommentPublicationDate?: Date
    public comments: Array<string>
    public postImage?: string

    public constructor(post: Post) {
        this.id = post.id;
        this.text = post.text;
        this.userImageUrl = post.userImageUrl;
        this.userNickName = post.userNickName;
        this.publicationDate = post.publicationDate;
        this.firstCommentText = post.firstCommentText;
        this.firstCommentUserImageUrl = post.firstCommentUserImageUrl;
        this.firstCommentUserNickName = post.firstCommentUserNickName;
        this.firstCommentPublicationDate = post.firstCommentPublicationDate;
        this.comments = post.idComments;
        this.postImage = post.imageUrl;

    }

}
