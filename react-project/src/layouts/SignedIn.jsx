import React from 'react'
import {Dropdown, Image, Menu} from 'semantic-ui-react'

export default function SignedIn(props) {
    return (
        <div>
            <Menu.Item>
                <Image avatar spaced="right" src="https://www.innovaxn.eu/wp-content/uploads/blank-profile-picture-973460_1280.png" />
                <Dropdown pointing="top left" text="Berkcan">
                    <Dropdown.Menu>
                        <Dropdown.Item text="Bilgilerim" icon="info" />
                        <Dropdown.Item onClick={props.signOut} text="Çıkış Yap" icon="sign-out" />

                    </Dropdown.Menu>
                </Dropdown>
            </Menu.Item>
        </div>
    )
}
