package service.equipment;

import domain.contract.Contract;
import domain.equipment.EquipmentEntity;
import domain.equipment.EquipmentEventRepository;
import domain.equipment.EquipmentRepository;
import domain.equipment.RegisterEquipmentEventList;
import domain.shipping.evnet.ShipEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public class EquipmentRegisterService {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    EquipmentEventRepository equipmentEventRepository;

    public void register(Contract contract,ShipEvent shipEvent){
        RegisterEquipmentEventList registerEquipmentEventList = RegisterEquipmentEventList.from(contract,shipEvent);
        registerEquipmentEventList.getRegisterEquipmentEventList()
                .stream().forEach(equipmentEventRepository::save);

        registerEquipmentEventList.getRegisterEquipmentEventList()
                .stream().map(EquipmentEntity::from).forEach(equipmentRepository::register);
    }
}
