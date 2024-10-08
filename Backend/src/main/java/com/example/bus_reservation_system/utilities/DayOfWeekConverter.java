// package com.example.bus_reservation_system.utilities;

// import java.time.DayOfWeek;
// import java.util.Arrays;
// import java.util.List;
// import java.util.stream.Collectors;

// public class DayOfWeekConverter {

    
//     public static String convertToString(List<DayOfWeek> days) {
//         return days.stream()
//                    .map(Enum::name)  
//                    .collect(Collectors.joining(","));
//     }

    
//     public static List<DayOfWeek> convertToEnumList(String days) {
//         return Arrays.stream(days.split(","))
//                      .map(DayOfWeek::valueOf)  
//                      .collect(Collectors.toList());
//     }
// }
