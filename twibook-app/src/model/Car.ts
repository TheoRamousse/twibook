class Car {
  readonly id: string;
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

  public isEqual(carToCompare: Car){
    if(this._model == carToCompare._model
      && this._brand == carToCompare._brand
      && this._color == carToCompare._color)
      return true;
    return false;
  }
}
