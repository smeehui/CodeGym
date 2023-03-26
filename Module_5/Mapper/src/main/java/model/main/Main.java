package model.main;

import model.dto.RoleDTO;
import model.dto.UserDTO;
import model.mapper.ERole;
import model.mapper.User;
import model.mapper.UserMapper;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserMapper mapper = UserMapper.getInstance();
        ModelMapper modelMapper = new ModelMapper();


        User user = new User();
//        user.setAge(22);
//        user.setFullName("Huy Nguyễn");
//        user.setPassword("123456");
//
//        Role roleAdmin = new Role(ERole.ADMIN);
//        Role roleUser = new Role(ERole.USER);
//
//        List<Role> roles = new ArrayList<>();
//        roles.add(roleUser);
//        roles.add(roleAdmin);
//
//        user.setRoles(roles);
//        System.out.println(user);
//
//        UserDTO userDTO = mapper.toDto(user);
//        System.out.println(userDTO);
//
//
//        User user1 = mapper.toEntity(userDTO);
//        System.out.println(user1);

        List<RoleDTO> roleDTOS = new ArrayList<>();
        roleDTOS.add(new RoleDTO(ERole.valueOf("ADMIN")));
        roleDTOS.add(new RoleDTO(ERole.valueOf("USER")));

        UserDTO userDTO = new UserDTO("Huy Nguyễn", "123123", roleDTOS, "12");

        User user = mapper.toEntity(userDTO);
        System.out.println(user);

        User mapEntity = modelMapper.map(userDTO, User.class);
        System.out.println(mapEntity);

        UserDTO mapDto = modelMapper.map(user, UserDTO.class);
        System.out.println(mapDto);

    }
}
