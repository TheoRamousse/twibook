import { Color } from './Color';
import { validateNewCar } from './Validator'

export class Car {
  private readonly id: string;
  private _model: string;
  private _brand: string;
  private _color: Color;

  public constructor(id: string, model: string,
    brand: string,
    color: Color) {

    validateNewCar(id, model, brand);

    this.id = id;
    this._model = model;
    this._brand = brand;
    this._color = color;
  }

  public isEqual(carToCompare: Car) {
    if (this._model == carToCompare._model
      && this._brand == carToCompare._brand
      && this._color == carToCompare._color)
      return true;
    return false;
  }

  public get model() {
    return this._model;
  }

  public set model(theModel: string) {
    if (theModel == null || theModel == "" || theModel.length > 50) {
      throw new Error("-model- est invalide");
    }
    this._model = theModel;
  }


  public get brand() {
    return this._brand;
  }

  public set brand(theBrand: string) {
    if (theBrand == null || theBrand == "" || theBrand.length > 50) {
      throw new Error("-brand- est invalide");
    }
    this._brand = theBrand;
  }



  public get color() {
    return this._color;
  }

  public set color(theColor: Color) {
    if (theColor == null) {
      throw new Error("-color- est invalide");
    }
    this._color = theColor;
  }
}
