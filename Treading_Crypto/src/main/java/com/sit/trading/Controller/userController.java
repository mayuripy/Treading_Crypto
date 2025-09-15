package com.sit.trading.Controller;


@RestController
@RequestMapping("/api/users")
@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
public class UserController {

 @Autowired
 private UserService userService;

 @GetMapping("/{id}")
 public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
     return ResponseEntity.ok(userService.getUserById(id));
 }

 @GetMapping
 public ResponseEntity<List<UserDto>> getAllUsers() {
     return ResponseEntity.ok(userService.getAllUsers());
 }

 @PostMapping
 public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserCreateDto dto) {
     return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
     userService.deleteUser(id);
     return ResponseEntity.ok(Map.of("ok", true));
 }
}
