import { Post } from "../Post";

export interface Persistence {
    getPosts(): Array<Post>;
}