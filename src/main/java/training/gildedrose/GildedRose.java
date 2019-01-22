package training.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemSellIn(item);

            if (qualityChanges(item)) {
                updateItemQuality(item);
            }
        }
    }

    private void updateItemSellIn(Item item) {
        if (!isGoldCoin(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void updateItemQuality(Item item) {
        if (isAgedBrie(item)) {
            updateAgedBrieQuality(item);

        } else if (isBackstagePass(item)) {
            updateBackstagePassQuality(item);

        } else {
            updateOtherItemQuality(item);
        }

        limitQuality(item);
    }

    private void updateAgedBrieQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = item.quality + 2;
        } else {
            item.quality = item.quality + 1;
        }
    }

    private void updateBackstagePassQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;

        } else if (item.sellIn <= 5) {
            item.quality = item.quality + 3;

        } else if (item.sellIn <= 10) {
            item.quality = item.quality + 2;

        } else {
            item.quality = item.quality + 1;
        }
    }

    private void updateOtherItemQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = item.quality - 2;
        } else {
            item.quality = item.quality - 1;
        }
    }

    private boolean qualityChanges(Item item) {
        return !isGoldCoin(item);
    }

    private void limitQuality(Item item) {
        if (item.quality < 0) {
            item.quality = 0;
        }
        if (item.quality > 50) {
            item.quality = 50;
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage pass");
    }

    private boolean isGoldCoin(Item item) {
        return item.name.equals("Gold coin");
    }
}