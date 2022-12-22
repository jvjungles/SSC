export interface ICelItem {
  id?: number;
  celItemName?: string | null;
  celItemDescription?: string | null;
  celItemValor?: number | null;
}

export const defaultValue: Readonly<ICelItem> = {};
