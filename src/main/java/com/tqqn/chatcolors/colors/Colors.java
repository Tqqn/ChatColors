package com.tqqn.chatcolors.colors;

import org.bukkit.Material;

public enum Colors {

    NONE("", "None", Material.BARRIER),
    BLACK("&0", "Black", Material.BLACK_WOOL),
    DARK_RED("&4", "Dark Red", Material.REDSTONE);

    private final String color;
    private final String prettyName;
    private final Material guiMaterial;
    private int size;
    Colors(String color, String prettyName, Material guiMaterial) {
        this.color = color;
        this.prettyName = prettyName;
        this.guiMaterial = guiMaterial;
        this.size = Colors.values().length;
    }

    public String getColor() {
        return color;
    }

    public String getPrettyName() {
        return prettyName;
    }

    public Material getGuiMaterial() {
        return guiMaterial;
    }

    public int getSize() {
        return size;
    }
}

