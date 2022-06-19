import { Car } from "./Car";
import { User } from "./User";

export class UserFromApi {
    public id: string;
    public cars: Array<Car>
    public firstName: string;
    public lastName: string;
    public nickName: string;
    public imageUrl: string;
    public birthDate: Date;
    public email: string;
    public password: string;
    public posts: Array<string>


    public constructor(user: User) {
        this.birthDate = user.birthDate;
        this.cars = user.cars;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.id = user.id;
        this.nickName = user.nickName;
        this.imageUrl = user.imageUrl;
        this.email = user.email;
        this.password = user.hashedPassword;
        this.posts = user.posts;
    }
}