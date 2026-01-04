package tn.esprit.tpfoyer17.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer17.entities.Chambre;
import tn.esprit.tpfoyer17.entities.enumerations.TypeChambre;
import tn.esprit.tpfoyer17.services.ChambreService;
import tn.esprit.tpfoyer17.services.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("api/chambres")
public class ChambreController {
    IChambreService chambreService;
    @PostMapping("chambres/add")
    public Chambre addingChambre(@RequestBody Chambre chambre){
        return chambreService.addChambre(chambre);
    }
    @GetMapping("chambres/getAll")
    public List<Chambre> gettingAllChambre(){
        return chambreService.getAllChambres();
    }

    @GetMapping("chambres/get")
    public Chambre gettingChambre(@RequestParam("idChambre") long idChambre){
        return chambreService.getChambreById(idChambre);
    }

    @DeleteMapping("chambres/delete/{idChambre}")
    public void deletingChambre(@PathVariable("idChambre") long idChambre){
        chambreService.deleteChambre(idChambre);
    }

    @PutMapping("chambres/update")
    public Chambre updatingChambre(@RequestBody Chambre chambre){
        return chambreService.updateChambre(chambre);
    }

    @GetMapping("chambres/get-par-nom-universite")
    public List<Chambre>  getChambresParNomUniversite( String nomUniversite) {
        return chambreService.getChambresParNomUniversite(nomUniversite);

    }
    @GetMapping("chambres/get-par-bloc-type-keyword")
    public List<Chambre> getChambresParBlocEtTypeKeyWord(@RequestParam("idBloc") long idBloc,@RequestParam("typeC") TypeChambre typeC) {
        return getChambresParBlocEtTypeKeyWord(idBloc,typeC);
    }
    @GetMapping("chambres/get-par-bloc-type-jpql")
    public List<Chambre> getChambresParBlocEtTypeJPQL(@RequestParam("idBloc") long idBloc,@RequestParam("typeC") TypeChambre typeC) {
        return chambreService.getChambresParBlocEtTypeJPQL(idBloc,typeC);
    }
    @GetMapping("chambres/get-non-reserve-par-nom-universite-typechambre")
    public List<Chambre>  getChambresNonReserveParNomUniversiteEtTypeChambre( @RequestParam("nomUniversite") String nomUniversite,@RequestParam("type") TypeChambre type) {
        return chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite,type);
    }
}
