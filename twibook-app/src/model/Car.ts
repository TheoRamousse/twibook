class Car {
  readonly id: string;
  private model: string;
  private brand: string;
  private color: Color;

  public constructor(id: string, model: string,
    brand: string,
    color: Color) {

      validateNewCar(id, model, brand);

      this.id = id;
      this.model = model;
      this.brand = brand;
      this.color = color;
  }
}
