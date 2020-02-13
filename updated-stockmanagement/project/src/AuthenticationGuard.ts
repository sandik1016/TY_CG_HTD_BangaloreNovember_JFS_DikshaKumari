import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})

export class AuthenticationGuard implements CanActivate {

    canActivate(route: ActivatedRouteSnapshot): boolean {
        const userDetails = JSON.parse(localStorage.getItem('userDetails'));
        const expectedRolesArray = route.data.expectedRoles;
        let expectedRole: string;
        for (const index in expectedRolesArray) {
            if (userDetails && userDetails.user.role === expectedRolesArray[index]) {
                expectedRole = expectedRolesArray[index];
            }
        }

        if ( userDetails && userDetails.user.role === expectedRole) {
            return true;
        } else {
            return false;
        }
    }
}
