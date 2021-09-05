package tesis.company.controllers;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tesis.company.models.Branch;
import tesis.company.services.BranchService;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/branches")
@RestController
@XRayEnabled
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    public List<Branch> save(@RequestBody List<Branch> branches) {
        return branchService.save(branches);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        branchService.deleteById(id);
    }

    @GetMapping("{id}")
    public Branch getById(@PathVariable("id") Long id) { return branchService.getById(id); }

    @GetMapping
    public List<Branch> getByUserId(@RequestParam("user_id") Long userId){
        return branchService.getByUserId(userId);
    }
}
