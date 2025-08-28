package com.mc.d_strategy.items;

import com.mc.d_strategy.items.code.EquipmentData;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Equipments {
    private final Map<Slot, Equipment> equipments;

    public Equipments() {
        equipments = new HashMap<>();
        this.equip(EquipmentData.BASIC_WEAPON);
    }

    public void equip(EquipmentData equipment) {
        Equipment eq = equipment.create();
        this.equipments.put(eq.getSlot(), eq);
    }

    public void unEquip(Slot slot) {
        if (slot == Slot.WEAPON) {
            this.equip(EquipmentData.BASIC_WEAPON);
            return;
        }
        this.equipments.remove(slot);
    }

    public Collection<Equipment> findAll() {
        return this.equipments.values();
    }

    public Optional<Equipment> getEquipment(Slot slot) {
        return Optional.of(this.equipments.get(slot));
    }
}
