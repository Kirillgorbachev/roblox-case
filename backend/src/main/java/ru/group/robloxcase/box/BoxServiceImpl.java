package ru.group.robloxcase.box;

import org.springframework.stereotype.Service;
import ru.group.robloxcase.box.chance.Chance;
import ru.group.robloxcase.box.rarity.BoxRarity;
import ru.group.robloxcase.exception.NotFoundException;
import ru.group.robloxcase.pet.card.PetCard;
import ru.group.robloxcase.pet.card.PetCardRepository;
import ru.group.robloxcase.pet.rarity.PetRarity;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoxServiceImpl implements BoxService{

    private final BoxRepository boxRepository;
    private final PetCardRepository petCardRepository;

    public BoxServiceImpl(BoxRepository boxRepository, PetCardRepository petCardRepository) {
        this.boxRepository = boxRepository;
        this.petCardRepository = petCardRepository;
    }

    @Override
    public Box create(BoxDto boxDto) {
        Box box = new Box();
        box.setName(boxDto.name());
        box.setPrice(boxDto.price());
        Long rarityId = boxDto.rarityId();
        if(rarityId == null){
            throw new IllegalArgumentException("Field 'rarity' of class Pet cannot be NULL");
        }
        BoxRarity rarity;
        if(rarityId.equals(PetRarity.COMMON.getId())){
            rarity = BoxRarity.COMMON;
        } else if(rarityId.equals(PetRarity.UNCOMMON.getId())){
            rarity = BoxRarity.UNCOMMON;
        } else if (rarityId.equals(PetRarity.RARE.getId())) {
            rarity = BoxRarity.RARE;
        } else if (rarityId.equals(PetRarity.LEGENDARY.getId())) {
            rarity = BoxRarity.LEGENDARY;
        } else {
            throw new NotFoundException(String.format("BoxRarity with ID=%1$s not found", rarityId));
        }
        box.setRarity(rarity);

        List<Chance> chances = boxDto.chances().stream()
                .map(chanceDto -> {
                    PetCard petCard = petCardRepository.findById(chanceDto.petCardId())
                            .orElseThrow(() -> new NotFoundException(String.format("PetCard with ID %d not found", chanceDto.petCardId())));
                    return new Chance(petCard, box, chanceDto.percent());
                })
                .collect(Collectors.toList());

        box.setChances(chances);
        return boxRepository.save(box);
    }

    @Override
    public Box patchById(Long boxId, BoxDto boxDto) {
        Box box = boxRepository.findById(boxId)
                .orElseThrow(() -> new NotFoundException(String.format("Box with ID %d not found", boxId)));

        if (boxDto.name() != null) {
            box.setName(boxDto.name());
        }
        if (boxDto.price() != null) {
            box.setPrice(boxDto.price());
        }
        if (boxDto.chances() != null) {
            box.getChances().clear();
            List<Chance> chances = boxDto.chances().stream()
                    .map(chanceDto -> {
                        PetCard petCard = petCardRepository.findById(chanceDto.petCardId())
                                .orElseThrow(() -> new NotFoundException(String.format("PetCard with ID %d not found", chanceDto.petCardId())));
                        return new Chance(petCard, box, chanceDto.percent());
                    })
                    .collect(Collectors.toList());
            box.setChances(chances);
        }
        Long rarityId = boxDto.rarityId();
        if(rarityId != null){
            BoxRarity rarity;
            if(rarityId.equals(PetRarity.COMMON.getId())){
                rarity = BoxRarity.COMMON;
            } else if(rarityId.equals(PetRarity.UNCOMMON.getId())){
                rarity = BoxRarity.UNCOMMON;
            } else if (rarityId.equals(PetRarity.RARE.getId())) {
                rarity = BoxRarity.RARE;
            } else if (rarityId.equals(PetRarity.LEGENDARY.getId())) {
                rarity = BoxRarity.LEGENDARY;
            } else {
                throw new NotFoundException(String.format("BoxRarity with ID=%1$s not found", rarityId));
            }
            box.setRarity(rarity);
        }
        return boxRepository.save(box);
    }

    @Override
    public Box findById(Long boxId) {
        return boxRepository.findById(boxId)
                .orElseThrow(() -> new NotFoundException(String.format("Box with ID %d not found", boxId)));
    }

    @Override
    public void deleteById(Long boxId) {
        Box box = boxRepository.findById(boxId)
                .orElseThrow(() -> new NotFoundException(String.format("Box with ID %d not found", boxId)));
        boxRepository.delete(box);
    }

    @Override
    public List<Box> findAll() {
        return boxRepository.findAll();
    }
}
