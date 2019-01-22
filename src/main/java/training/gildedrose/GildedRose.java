package training.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemSellIn(item);
            updateItemQuality(item);
        }
    }

    private void updateItemSellIn(Item item) {
        if (!item.name.equals("Gold coin")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateItemQuality(Item item) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage pass")) {
            if (item.quality > 0) {
                if (!item.name.equals("Gold coin")) {
                    item.quality = item.quality - 1;
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;

                if (item.name.equals("Backstage pass")) {
                    if (item.sellIn <= 10) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn <= 5) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage pass")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Gold coin")) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}